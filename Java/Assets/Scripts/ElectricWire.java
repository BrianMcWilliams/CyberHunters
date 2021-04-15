import unityengine.*;

public class ElectricWire extends MonoBehaviour
{
	public GameObject buttonPickUp;
	private void Start()
	{
		buttonPickUp.SetActive(false);
	}
	private void OnCollisionEnter(Collision collision)
	{
		GameObject collisionObject = collision.gameObject;
		PlayerMovement mouvementComponant = gameObject.<PlayerMovement>GetComponent();
		if (mouvementComponant == null)
		{
			return;
		}
		else
		{
			buttonPickUp.SetActive(true);
		}
	}
	private void OnCollisionExit(Collision collision)
	{
		GameObject collisionObject = collision.gameObject;
		PlayerMovement mouvementComponant = gameObject.<PlayerMovement>GetComponent();
		if (mouvementComponant == null)
		{
			return;
		}
		else
		{
			buttonPickUp.SetActive(false);
		}
	}
}