import unityengine.*;
import TMPro.*;
import java.util.*;

public enum Character
{
	Player,
	Robot;

	public static final int SIZE = java.lang.Integer.SIZE;

	public int getValue()
	{
		return this.ordinal();
	}

	public static Character forValue(int value)
	{
		return values()[value];
	}
}