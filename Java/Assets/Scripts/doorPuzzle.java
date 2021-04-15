import unityengine.*;

public class doorPuzzle extends MonoBehaviour
{

	public GameObject doorGear;

	public final void Use()
	{
		for (Transform child : transform)
		{
			GameObject.Destroy(child.gameObject);
		}

		if (doorGear != null)
		{
			doorGear.SetActive(true);
		}
	}





}