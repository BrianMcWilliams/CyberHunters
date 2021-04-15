import unityengine.*;

public class DialogStart extends MonoBehaviour
{
	public GameObject dialog;

	private void OnCollisionEnter2D(Collision2D other)
	{
		dialog.SetActive(true);
	}
}