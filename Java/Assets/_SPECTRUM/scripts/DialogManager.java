import unityengine.*;

public class DialogManager extends MonoBehaviour
{
	public static boolean isTalking = false;
	public static int indexEnd;

	// Start is called before the first frame update
	private void Start()
	{

	}

	// Update is called once per frame
	private void Update()
	{


	}

	public static void StartTalking()
	{
		isTalking = true;
	}

	public static void StopTalking()
	{
		isTalking = false;
	}

}