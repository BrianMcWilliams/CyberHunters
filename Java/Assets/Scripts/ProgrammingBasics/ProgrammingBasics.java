import unityengine.*;

public class ProgrammingBasics extends MonoBehaviour
{
	public TextMesh textMesh; //These are variables, use them to modify the text you see on screen
	public TextMesh timerTextMesh;
	public Color initialColor;
	public Color finalColor;
	public Color currentColor;

	// Start is called before the first frame update
	private void Start()
	{
		//These variables we are going to use for storing our messages, try using these with Debug.Log()
		String myMessageForTheConsole = "Write something here";
		String myTextForTheScreen = "Text to put on screen";
		initialColor = new Color(1.0f, 0.1f, 1.0f);
		currentColor = initialColor;


		Debug.Log("Hello World");

		Debug.Log(myMessageForTheConsole + " and " + myTextForTheScreen);

		//You can use textMesh.text and textMesh.color to modify the text and color you see on screen;
		//Keep in mind there are 2 textMesh variables, pay attention to which one you are modifying

		textMesh.text = "I love bagels"; //Red,Green,Blue

	}

	private float initalTime = 8.0f;
	private float timeToWait = 8.0f;
	// Update is called once per frame
	private void Update()
	{
		float proportion = timeToWait / initalTime;
		timeToWait -= Time.deltaTime;
		timerTextMesh.text = String.valueOf(timeToWait);

		currentColor = new Color(proportion * 1.0f, proportion * 0.1f, proportion * 1.0f);
		textMesh.color = currentColor;

	}
}