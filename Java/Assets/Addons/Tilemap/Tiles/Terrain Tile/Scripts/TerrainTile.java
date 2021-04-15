//====================================================================================================
//The Free Edition of C# to Java Converter limits conversion output to 100 lines per file.

//To purchase the Premium Edition, visit our website:
//https://www.tangiblesoftwaresolutions.com/order/order-csharp-to-java.html
//====================================================================================================

package unityengine.tilemaps;

import java.io.*;

//C# TO JAVA CONVERTER TODO TASK: There is no preprocessor in Java:
//#if UNITY_EDITOR
import UnityEditor.*;
//#endif

import unityengine.*;

import unityengine.*;

public class TerrainTile extends TileBase implements Serializable
{
//C# TO JAVA CONVERTER TODO TASK: Java annotations will not correspond to .NET attributes:
//ORIGINAL LINE: [SerializeField] public Sprite[] m_Sprites;
	public Sprite[] m_Sprites;

	@Override
	public void RefreshTile(Vector3Int location, ITilemap tileMap)
	{
		for (int yd = -1; yd <= 1; yd++)
		{
			for (int xd = -1; xd <= 1; xd++)
			{
				Vector3Int position = new Vector3Int(location.x + xd, location.y + yd, location.z);
				if (TileValue(tileMap, position))
				{
					tileMap.RefreshTile(position);
				}
			}
		}
	}

	@Override
	public void GetTileData(Vector3Int location, ITilemap tileMap, tangible.RefObject<TileData> tileData)
	{
		UpdateTile(location, tileMap, tileData);
	}

	private void UpdateTile(Vector3Int location, ITilemap tileMap, tangible.RefObject<TileData> tileData)
	{
		tileData.refArgValue.transform = Matrix4x4.identity;
		tileData.refArgValue.color = Color.white;

		int mask = TileValue(tileMap, location + new Vector3Int(0, 1, 0)) ? 1 : 0;
		mask += TileValue(tileMap, location + new Vector3Int(1, 1, 0)) ? 2 : 0;
		mask += TileValue(tileMap, location + new Vector3Int(1, 0, 0)) ? 4 : 0;
		mask += TileValue(tileMap, location + new Vector3Int(1, -1, 0)) ? 8 : 0;
		mask += TileValue(tileMap, location + new Vector3Int(0, -1, 0)) ? 16 : 0;
		mask += TileValue(tileMap, location + new Vector3Int(-1, -1, 0)) ? 32 : 0;
		mask += TileValue(tileMap, location + new Vector3Int(-1, 0, 0)) ? 64 : 0;
		mask += TileValue(tileMap, location + new Vector3Int(-1, 1, 0)) ? 128 : 0;

//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: byte original = (byte)mask;
		byte original = (byte)mask;
		if ((original | 254) < 255)
		{
			mask = mask & 125;
		}
		if ((original | 251) < 255)
		{
			mask = mask & 245;
		}
		if ((original | 239) < 255)
		{
			mask = mask & 215;
		}
		if ((original | 191) < 255)
		{
			mask = mask & 95;
		}

//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: int index = GetIndex((byte)mask);
		int index = GetIndex((byte)mask);
		if (index >= 0 && index < m_Sprites.length && TileValue(tileMap, location))
		{
			tileData.refArgValue.sprite = m_Sprites[index];
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: tileData.transform = GetTransform((byte)mask);
			tileData.refArgValue.transform = GetTransform((byte)mask);
			tileData.refArgValue.color = Color.white;
			tileData.refArgValue.flags = TileFlags.LockTransform | TileFlags.LockColor;
			tileData.refArgValue.colliderType = Tile.ColliderType.Sprite;
		}
	}

	private boolean TileValue(ITilemap tileMap, Vector3Int position)
	{
		TileBase tile = tileMap.GetTile(position);
		return (tile != null && tile == this);
	}

//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: private int GetIndex(byte mask)
	private int GetIndex(byte mask)
	{
		switch (mask)
		{
			case 0:
				return 0;
			case 1:
			case 4:
			case 16:
			case 64:
				return 1;
			case 5:
			case 20:
			case 80:
			case 65:
				return 2;
			case 7:
			case 28:
			case 112:
			case 193:
				return 3;
			case 17:
			case 68:
				return 4;
			case 21:
			case 84:
			case 81:
			case 69:
				return 5;
			case 23:
			case 92:
			case 113:
			case 197:
				return 6;
			case 29:
			case 116:
			case 209:
			case 71:
				return 7;
			case 31:
			case 124:
			case 241:
			case 199:
				return 8;
			case 85:
				return 9;
			case 87:
			case 93:
			case 117:
			case 213:
				return 10;
			case 95:
			case 125:
			case 245:
			case 215:
				return 11;
			case 119:

//====================================================================================================
//End of the allowed output for the Free Edition of C# to Java Converter.

//To purchase the Premium Edition, visit our website:
//https://www.tangiblesoftwaresolutions.com/order/order-csharp-to-java.html
//====================================================================================================
