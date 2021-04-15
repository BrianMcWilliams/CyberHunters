import unityengine.*;

public class checkpoint extends MonoBehaviour
{

	public GameObject destination;

	private void OnTriggerEnter2D(Collider2D col)
	{

		if (col.CompareTag("Player"))
		{
			col.transform.position = destination.transform.position;
			Handheld.Vibrate();
		}
	}

}