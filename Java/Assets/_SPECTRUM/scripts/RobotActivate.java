import unityengine.*;

public class RobotActivate extends MonoBehaviour
{
	public GameObject robot;
	public GameObject dialog;

	private void OnCollisionEnter2D(Collision2D other)
	{
		GameObject Robot = other.gameObject;
		if (Robot.CompareTag("Robot"))
		{
			Robot.SetActive(false);
			robot.SetActive(true);
			dialog.SetActive(true);
		}
		else
		{
			return;

		}
	}

}