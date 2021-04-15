import unityengine.*;
import unityengine.EventSystems.*;

// This script controls an onscreen touch button. Most of this code exists purely to provide
// a simple input method, and as such, won't be fully commented


public class TouchButton extends MonoBehaviour implements IPointerDownHandler, IPointerUpHandler
{
	private int pointerID;
	private boolean buttonHeld;
	private boolean buttonPressed;

	private void Awake()
	{
		pointerID = -999;
	}

	//When the screen is first touched
	public final void OnPointerDown(PointerEventData data)
	{
		if (pointerID != -999)
		{
			return;
		}

		pointerID = data.pointerId;

		buttonHeld = true;
		buttonPressed = true;
	}

	//When the finger leaves the screen
	public final void OnPointerUp(PointerEventData data)
	{
		if (data.pointerId != pointerID)
		{
			return;
		}

		pointerID = -999;
		buttonHeld = false;
		buttonPressed = false;
	}

	//Functions like Input.GetButtonDown()
	public final boolean GetButtonDown()
	{
		if (buttonPressed)
		{
			buttonPressed = false;
			return true;
		}

		return false;
	}

	//Functions like Input.GetButton()
	public final boolean GetButton()
	{
		return buttonHeld;
	}
}