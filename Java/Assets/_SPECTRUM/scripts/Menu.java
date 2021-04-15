import unityengine.*;
import unityengine.SceneManagement.*;

public class Menu extends MonoBehaviour
{


	public final void LoadScene(int index)
	{

		SceneManager.LoadScene(index);
	}

}