//====================================================================================================
//The Free Edition of C# to Java Converter limits conversion output to 100 lines per file.

//To purchase the Premium Edition, visit our website:
//https://www.tangiblesoftwaresolutions.com/order/order-csharp-to-java.html
//====================================================================================================

package unityengine.tilemaps;

import java.util.*;
import java.io.*;

import unityengine.*;

public enum GridInformationType
{
	Integer,
	String,
	Float,
	Double,
	UnityObject,
	Color;

	public static final int SIZE = java.lang.Integer.SIZE;

	public int getValue()
	{
		return this.ordinal();
	}

	public static GridInformationType forValue(int value)
	{
		return values()[value];
	}
}

//C# TO JAVA CONVERTER TODO TASK: Java annotations will not correspond to .NET attributes:
//ORIGINAL LINE: [Serializable][AddComponentMenu("Tilemap/Grid Information")] public class GridInformation : MonoBehaviour, ISerializationCallbackReceiver
public class GridInformation extends MonoBehaviour implements ISerializationCallbackReceiver, Serializable
{
//C# TO JAVA CONVERTER WARNING: Java does not allow user-defined value types. The behavior of this class may differ from the original:
//ORIGINAL LINE: internal struct GridInformationValue
	public final static class GridInformationValue
	{
		public GridInformationType type = GridInformationType.values()[0];
		public Object data;

		public GridInformationValue clone()
		{
			GridInformationValue varCopy = new GridInformationValue();

			varCopy.type = this.type;
			varCopy.data = this.data;

			return varCopy;
		}
	}

//C# TO JAVA CONVERTER WARNING: Java does not allow user-defined value types. The behavior of this class may differ from the original:
//ORIGINAL LINE: [Serializable] internal struct GridInformationKey
	public final static class GridInformationKey implements Serializable
	{
		public Vector3Int position;
		public String name;

		public GridInformationKey clone()
		{
			GridInformationKey varCopy = new GridInformationKey();

			varCopy.position = this.position;
			varCopy.name = this.name;

			return varCopy;
		}
	}

	private HashMap<GridInformationKey, GridInformationValue> m_PositionProperties = new HashMap<GridInformationKey, GridInformationValue>();
	public final HashMap<GridInformationKey, GridInformationValue> getPositionProperties()
	{
		return m_PositionProperties;
	}

//C# TO JAVA CONVERTER TODO TASK: Java annotations will not correspond to .NET attributes:
//ORIGINAL LINE: [SerializeField][HideInInspector] private List<GridInformationKey> m_PositionIntKeys = new List<GridInformationKey>();
	private ArrayList<GridInformationKey> m_PositionIntKeys = new ArrayList<GridInformationKey>();

//C# TO JAVA CONVERTER TODO TASK: Java annotations will not correspond to .NET attributes:
//ORIGINAL LINE: [SerializeField][HideInInspector] private List<int> m_PositionIntValues = new List<int>();
	private ArrayList<Integer> m_PositionIntValues = new ArrayList<Integer>();

//C# TO JAVA CONVERTER TODO TASK: Java annotations will not correspond to .NET attributes:
//ORIGINAL LINE: [SerializeField][HideInInspector] private List<GridInformationKey> m_PositionStringKeys = new List<GridInformationKey>();
	private ArrayList<GridInformationKey> m_PositionStringKeys = new ArrayList<GridInformationKey>();

//C# TO JAVA CONVERTER TODO TASK: Java annotations will not correspond to .NET attributes:
//ORIGINAL LINE: [SerializeField][HideInInspector] private List<String> m_PositionStringValues = new List<String>();
	private ArrayList<String> m_PositionStringValues = new ArrayList<String>();

//C# TO JAVA CONVERTER TODO TASK: Java annotations will not correspond to .NET attributes:
//ORIGINAL LINE: [SerializeField][HideInInspector] private List<GridInformationKey> m_PositionFloatKeys = new List<GridInformationKey>();
	private ArrayList<GridInformationKey> m_PositionFloatKeys = new ArrayList<GridInformationKey>();

//C# TO JAVA CONVERTER TODO TASK: Java annotations will not correspond to .NET attributes:
//ORIGINAL LINE: [SerializeField][HideInInspector] private List<float> m_PositionFloatValues = new List<float>();
	private ArrayList<Float> m_PositionFloatValues = new ArrayList<Float>();

//C# TO JAVA CONVERTER TODO TASK: Java annotations will not correspond to .NET attributes:
//ORIGINAL LINE: [SerializeField][HideInInspector] private List<GridInformationKey> m_PositionDoubleKeys = new List<GridInformationKey>();
	private ArrayList<GridInformationKey> m_PositionDoubleKeys = new ArrayList<GridInformationKey>();

//C# TO JAVA CONVERTER TODO TASK: Java annotations will not correspond to .NET attributes:
//ORIGINAL LINE: [SerializeField][HideInInspector] private List<Double> m_PositionDoubleValues = new List<Double>();
	private ArrayList<Double> m_PositionDoubleValues = new ArrayList<Double>();

//C# TO JAVA CONVERTER TODO TASK: Java annotations will not correspond to .NET attributes:
//ORIGINAL LINE: [SerializeField][HideInInspector] private List<GridInformationKey> m_PositionObjectKeys = new List<GridInformationKey>();
	private ArrayList<GridInformationKey> m_PositionObjectKeys = new ArrayList<GridInformationKey>();

//C# TO JAVA CONVERTER TODO TASK: Java annotations will not correspond to .NET attributes:
//ORIGINAL LINE: [SerializeField][HideInInspector] private List<Object> m_PositionObjectValues = new List<Object>();
	private ArrayList<Object> m_PositionObjectValues = new ArrayList<Object>();

//C# TO JAVA CONVERTER TODO TASK: Java annotations will not correspond to .NET attributes:
//ORIGINAL LINE: [SerializeField][HideInInspector] private List<GridInformationKey> m_PositionColorKeys = new List<GridInformationKey>();
	private ArrayList<GridInformationKey> m_PositionColorKeys = new ArrayList<GridInformationKey>();

//C# TO JAVA CONVERTER TODO TASK: Java annotations will not correspond to .NET attributes:
//ORIGINAL LINE: [SerializeField][HideInInspector] private List<Color> m_PositionColorValues = new List<Color>();
	private ArrayList<Color> m_PositionColorValues = new ArrayList<Color>();

	public final void OnBeforeSerialize()
	{
		Grid grid = GetComponentInParent<Grid>();
		if (grid == null)
		{
			return;
		}

		m_PositionIntKeys.clear();
		m_PositionIntValues.clear();
		m_PositionStringKeys.clear();
		m_PositionStringValues.clear();
		m_PositionFloatKeys.clear();
		m_PositionFloatValues.clear();
		m_PositionDoubleKeys.clear();
		m_PositionDoubleValues.clear();
		m_PositionObjectKeys.clear();
		m_PositionObjectValues.clear();
		m_PositionColorKeys.clear();
		m_PositionColorValues.clear();

		for (var kvp : m_PositionProperties.entrySet())
		{
			switch (kvp.getValue().type)
			{
				case GridInformationType.Integer:
					m_PositionIntKeys.add(kvp.getKey().clone());
					m_PositionIntValues.add((int)kvp.getValue().data);
					break;
				case GridInformationType.String:
					m_PositionStringKeys.add(kvp.getKey().clone());
					m_PositionStringValues.add(kvp.getValue().data instanceof String ? (String)kvp.getValue().data : null);
					break;
				case GridInformationType.Float:
					m_PositionFloatKeys.add(kvp.getKey().clone());
					m_PositionFloatValues.add((float)kvp.getValue().data);
					break;
				case GridInformationType.Double:
					m_PositionDoubleKeys.add(kvp.getKey().clone());
					m_PositionDoubleValues.add((double)kvp.getValue().data);
					break;
				case GridInformationType.Color:
					m_PositionColorKeys.add(kvp.getKey().clone());
					m_PositionColorValues.add((Color)kvp.getValue().data);
					break;
				default:
					m_PositionObjectKeys.add(kvp.getKey().clone());
					m_PositionObjectValues.add(kvp.getValue().data instanceof Object ? (Object)kvp.getValue().data : null);
					break;
			}
		}
	}

	public final void OnAfterDeserialize()
	{
		m_PositionProperties.clear();
		for (int i = 0; i != Math.min(m_PositionIntKeys.size(), m_PositionIntValues.size()); i++)
		{
			GridInformationValue positionValue = new GridInformationValue();
			positionValue.type = GridInformationType.Integer;
			positionValue.data = m_PositionIntValues.get(i);
			m_PositionProperties.put(m_PositionIntKeys.get(i).clone(), positionValue.clone());
		}
		for (int i = 0; i != Math.min(m_PositionStringKeys.size(), m_PositionStringValues.size()); i++)
		{
			GridInformationValue positionValue = new GridInformationValue();
			positionValue.type = GridInformationType.String;

//====================================================================================================
//End of the allowed output for the Free Edition of C# to Java Converter.

//To purchase the Premium Edition, visit our website:
//https://www.tangiblesoftwaresolutions.com/order/order-csharp-to-java.html
//====================================================================================================
