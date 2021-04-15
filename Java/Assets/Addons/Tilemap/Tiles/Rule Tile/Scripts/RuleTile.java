//====================================================================================================
//The Free Edition of C# to Java Converter limits conversion output to 100 lines per file.

//To purchase the Premium Edition, visit our website:
//https://www.tangiblesoftwaresolutions.com/order/order-csharp-to-java.html
//====================================================================================================

package unityengine;

import java.util.*;
import java.io.*;

import unityengine.tilemaps.*;

//C# TO JAVA CONVERTER TODO TASK: Java annotations will not correspond to .NET attributes:
//ORIGINAL LINE: [Serializable][CreateAssetMenu] public class RuleTile : TileBase
public class RuleTile extends TileBase implements Serializable
{
	public Sprite m_DefaultSprite;
	public Tile.ColliderType m_DefaultColliderType = Tile.ColliderType.Sprite;

	public static class TilingRule implements Serializable
	{
		public Neighbor[] m_Neighbors;
		public Sprite[] m_Sprites;
		public float m_AnimationSpeed;
		public float m_PerlinScale;
		public Transform m_RuleTransform = Transform.values()[0];
		public OutputSprite m_Output = OutputSprite.values()[0];
		public Tile.ColliderType m_ColliderType;
		public Transform m_RandomTransform = Transform.values()[0];

		public TilingRule()
		{
			m_Output = OutputSprite.Single;
			m_Neighbors = new Neighbor[8];
			m_Sprites = new Sprite[1];
			m_AnimationSpeed = 1f;
			m_PerlinScale = 0.5f;
			m_ColliderType = Tile.ColliderType.Sprite;

			for (int i = 0; i < m_Neighbors.length; i++)
			{
				m_Neighbors[i] = Neighbor.DontCare;
			}
		}

		public enum Transform
		{
			Fixed,
			Rotated,
			MirrorX,
			MirrorY;

			public static final int SIZE = java.lang.Integer.SIZE;

			public int getValue()
			{
				return this.ordinal();
			}

			public static Transform forValue(int value)
			{
				return values()[value];
			}
		}
		public enum Neighbor
		{
			DontCare,
			This,
			NotThis;

			public static final int SIZE = java.lang.Integer.SIZE;

			public int getValue()
			{
				return this.ordinal();
			}

			public static Neighbor forValue(int value)
			{
				return values()[value];
			}
		}
		public enum OutputSprite
		{
			Single,
			Random,
			Animation;

			public static final int SIZE = java.lang.Integer.SIZE;

			public int getValue()
			{
				return this.ordinal();
			}

			public static OutputSprite forValue(int value)
			{
				return values()[value];
			}
		}
	}

//C# TO JAVA CONVERTER TODO TASK: Java annotations will not correspond to .NET attributes:
//ORIGINAL LINE: [HideInInspector] public List<TilingRule> m_TilingRules;
	public ArrayList<TilingRule> m_TilingRules;

	@Override
	public void GetTileData(Vector3Int position, ITilemap tileMap, tangible.RefObject<TileData> tileData)
	{
		tileData.refArgValue.sprite = m_DefaultSprite;
		tileData.refArgValue.colliderType = m_DefaultColliderType;
		tileData.refArgValue.flags = TileFlags.LockTransform;
		tileData.refArgValue.transform = Matrix4x4.identity;

		for (TilingRule rule : m_TilingRules)
		{
			Matrix4x4 transform = Matrix4x4.identity;
			tangible.RefObject<Matrix4x4> tempRef_transform = new tangible.RefObject<Matrix4x4>(transform);
			if (RuleMatches(rule, position, tileMap, tempRef_transform))
			{
			transform = tempRef_transform.refArgValue;
				switch (rule.m_Output)
				{
						case Single:
						case Animation:
							tileData.refArgValue.sprite = rule.m_Sprites[0];
						break;
						case Random:
							int index = Mathf.Clamp(Mathf.FloorToInt(GetPerlinValue(position, rule.m_PerlinScale, 100000f) * rule.m_Sprites.length), 0, rule.m_Sprites.length - 1);
							tileData.refArgValue.sprite = rule.m_Sprites[index];
							if (rule.m_RandomTransform != TilingRule.Transform.Fixed)
							{
								transform = ApplyRandomTransform(rule.m_RandomTransform, transform, rule.m_PerlinScale, position);
							}
						break;
				}
				tileData.refArgValue.transform = transform;
				tileData.refArgValue.colliderType = rule.m_ColliderType;
				break;
			}
		else
		{
			transform = tempRef_transform.refArgValue;
		}
		}
	}

	private static float GetPerlinValue(Vector3Int position, float scale, float offset)
	{
		return Mathf.PerlinNoise((position.x + offset) * scale, (position.y + offset) * scale);
	}

	@Override
	public boolean GetTileAnimationData(Vector3Int position, ITilemap tilemap, tangible.RefObject<TileAnimationData> tileAnimationData)
	{
		for (TilingRule rule : m_TilingRules)
		{
			Matrix4x4 transform = Matrix4x4.identity;
			tangible.RefObject<Matrix4x4> tempRef_transform = new tangible.RefObject<Matrix4x4>(transform);
			if (RuleMatches(rule, position, tilemap, tempRef_transform) && rule.m_Output == TilingRule.OutputSprite.Animation)
			{
			transform = tempRef_transform.refArgValue;
				tileAnimationData.refArgValue.animatedSprites = rule.m_Sprites;
				tileAnimationData.refArgValue.animationSpeed = rule.m_AnimationSpeed;
				return true;
			}
		else
		{
			transform = tempRef_transform.refArgValue;
		}
		}
		return false;
	}

	@Override
	public void RefreshTile(Vector3Int location, ITilemap tileMap)
	{
		if (m_TilingRules != null && !m_TilingRules.isEmpty())
		{
			for (int y = -1; y <= 1; y++)
			{
				for (int x = -1; x <= 1; x++)
				{
					super.RefreshTile(location + new Vector3Int(x, y, 0), tileMap);
				}
			}
		}
		else
		{

//====================================================================================================
//End of the allowed output for the Free Edition of C# to Java Converter.

//To purchase the Premium Edition, visit our website:
//https://www.tangiblesoftwaresolutions.com/order/order-csharp-to-java.html
//====================================================================================================
