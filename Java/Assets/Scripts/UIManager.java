import unityengine.*;
import TMPro.*;

// This script is a Manager that controls the UI HUD (deaths, time, and orbs) for the 
// project. All HUD UI commands are issued through the static methods of this class


public class UIManager extends MonoBehaviour
{
	//This class holds a static reference to itself to ensure that there will only be
	//one in existence. This is often referred to as a "singleton" design pattern. Other
	//scripts access this one through its public static methods
	private static UIManager current;

	public TextMeshProUGUI orbText; //Text element showing number of orbs
	public TextMeshProUGUI timeText; //Text element showing amount of time
	public TextMeshProUGUI deathText; //Text element showing number or deaths
	public TextMeshProUGUI gameOverText; //Text element showing the Game Over message


	private void Awake()
	{
		//If an UIManager exists and it is not this...
		if (current != null && current != this)
		{
			//...destroy this and exit. There can be only one UIManager
			Destroy(gameObject);
			return;
		}

		//This is the current UIManager and it should persist between scene loads
		current = this;
		DontDestroyOnLoad(gameObject);
	}

	public static void UpdateOrbUI(int orbCount)
	{
		//If there is no current UIManager, exit
		if (current == null)
		{
			return;
		}

		//Update the text orb element
		current.orbText.text = String.valueOf(orbCount);
	}

	public static void UpdateTimeUI(float time)
	{
		//If there is no current UIManager, exit
		if (current == null)
		{
			return;
		}

		//Take the time and convert it into the number of minutes and seconds
		int minutes = (int)(time / 60);
		float seconds = time % 60f;

		//Create the string in the appropriate format for the time
		current.timeText.text = (new Integer(minutes)).toString("00") + ":" + (new Float(seconds)).toString("00");
	}

	public static void UpdateDeathUI(int deathCount)
	{
		//If there is no current UIManager, exit
		if (current == null)
		{
			return;
		}

		//update the player death count element
		current.deathText.text = String.valueOf(deathCount);
	}

	public static void DisplayGameOverText()
	{
		//If there is no current UIManager, exit
		if (current == null)
		{
			return;
		}

		//Show the game over text
		current.gameOverText.enabled = true;
	}
}