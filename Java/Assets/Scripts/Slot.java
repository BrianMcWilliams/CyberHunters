import unityengine.*;

public class Slot extends MonoBehaviour
{

	public GameObject doorGear;
	public GameObject On;
	public GameObject button;
	private Inventory inventory;

	private void Start()
	{
		inventory = GameObject.FindGameObjectWithTag("door").<Inventory>GetComponent();
	}

	public final void Use()
	{

		for (Transform child : transform)
		{
			GameObject.Destroy(child.gameObject);
		}



		if (doorGear != null)
		{
			for (int i = 0; i < inventory.slots.length; i++)
			{

				if (inventory.isFull[i] == false)
				{
					inventory.isFull[i] = true;
					Instantiate(doorGear, inventory.slots[i].transform, false);
					break;
				}

				if (inventory.isFull[i] == true)
				{
					if (On && button != null)
					{
					   On.SetActive(true);
					   button.SetActive(true);
					}

				}

			}
		}



	}

}