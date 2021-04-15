import unityengine.*;
import unityengine.tilemaps.*;

//C# TO JAVA CONVERTER TODO TASK: Java annotations will not correspond to .NET attributes:
//ORIGINAL LINE: [ExecuteInEditMode] public class TintTextureGenerator : MonoBehaviour
public class TintTextureGenerator extends MonoBehaviour
{
	public int k_TintMapSize = 256;

	public final void Start()
	{
		Refresh(GetComponent<Grid>());
	}

	private Texture2D m_TintTexture;
	private Texture2D getTintTexture()
	{
		if (m_TintTexture == null)
		{
			m_TintTexture = new Texture2D(k_TintMapSize, k_TintMapSize, TextureFormat.ARGB32, false);
			m_TintTexture.hideFlags = HideFlags.HideAndDontSave;
			m_TintTexture.wrapMode = TextureWrapMode.Clamp;
			m_TintTexture.filterMode = FilterMode.Bilinear;
			RefreshGlobalShaderValues();
		}
		return m_TintTexture;
	}

	public final void Refresh(Grid grid)
	{
		if (grid == null)
		{
			return;
		}

		int w = getTintTexture().width;
		int h = getTintTexture().height;
		for (int y = 0; y < h; y++)
		{
			for (int x = 0; x < w; x++)
			{
				Vector3Int world = TextureToWorld(new Vector3Int(x, y, 0));
				getTintTexture().SetPixel(x, y, GetGridInformation(grid).GetPositionProperty(world, "Tint", Color.white));
			}
		}
		getTintTexture().Apply();
	}

	public final void Refresh(Grid grid, Vector3Int position)
	{
		if (grid == null)
		{
			return;
		}

		RefreshGlobalShaderValues();
		Vector3Int texPosition = WorldToTexture(position);
		getTintTexture().SetPixel(texPosition.x, texPosition.y, GetGridInformation(grid).GetPositionProperty(position, "Tint", Color.white));
		getTintTexture().Apply();
	}

	public final Color GetColor(Grid grid, Vector3Int position)
	{
		if (grid == null)
		{
			return Color.white;
		}

		return GetGridInformation(grid).GetPositionProperty(position, "Tint", Color.white);
	}

	public final void SetColor(Grid grid, Vector3Int position, Color color)
	{
		if (grid == null)
		{
			return;
		}

		GetGridInformation(grid).SetPositionProperty(position, "Tint", color);
		Refresh(grid, position);
	}

	private Vector3Int WorldToTexture(Vector3Int world)
	{
		return new Vector3Int(world.x + getTintTexture().width / 2, world.y + getTintTexture().height / 2, 0);
	}

	private Vector3Int TextureToWorld(Vector3Int texpos)
	{
		return new Vector3Int(texpos.x - getTintTexture().width / 2, texpos.y - getTintTexture().height / 2, 0);
	}

	private GridInformation GetGridInformation(Grid grid)
	{
		GridInformation gridInformation = grid.<GridInformation>GetComponent();

		if (gridInformation == null)
		{
			gridInformation = grid.gameObject.<GridInformation>AddComponent();
		}

		return gridInformation;
	}

	private void RefreshGlobalShaderValues()
	{
		Shader.SetGlobalTexture("_TintMap", m_TintTexture);
		Shader.SetGlobalFloat("_TintMapSize", k_TintMapSize);
	}
}