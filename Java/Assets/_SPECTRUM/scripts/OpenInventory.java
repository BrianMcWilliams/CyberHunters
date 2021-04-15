import unityengine.*;

public class OpenInventory extends MonoBehaviour
{
	public GameObject openButton;
	public GameObject exitButton;
	public GameObject inventory;

	public final void clickThisButton()
	{
		exitButton.SetActive(true);
		inventory.SetActive(true);
		openButton.SetActive(false);
	}

	public final void clickedThisButton()
	{
		exitButton.SetActive(false);
		inventory.SetActive(false);
		openButton.SetActive(true);
	}



}