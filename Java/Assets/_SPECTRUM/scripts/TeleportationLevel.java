import unityengine.*;
import unityengine.SceneManagement.*;
import java.util.*;

public class TeleportationLevel extends MonoBehaviour
{
	public int indexLevel;
	public Animator levelAnim;
	public Animator musicAnim;
	public float WaitTime;

	public final void Activate()
	{
		StartCoroutine(Wait());
		levelAnim.SetTrigger("FadeOut");
		DialogManager.isTalking = false;
	}

	private Iterator Wait()
	{
		musicAnim.SetTrigger("fadeOut");
//C# TO JAVA CONVERTER TODO TASK: Java does not have an equivalent to the C# 'yield' keyword:
		yield return new WaitForSeconds(WaitTime);
		SceneManager.LoadScene(indexLevel);
	}


}