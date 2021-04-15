import unityengine.*;

public class On extends MonoBehaviour
{
	public GameObject Activate;
	public GameObject button;


	private void Update()
	{
		for (Transform child : transform)
		{
			if (!child.gameObject.activeInHierarchy)
			{
				return;


			}
			else
			{
				Activate.SetActive(true);
				button.SetActive(true);
			}
		}

	}

}