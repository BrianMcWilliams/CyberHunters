import unityengine.*;
import unityengine.UI.*;

// This script is for determining Frames Per Second on mobile. This is only for diagnostics
// and shouldn't be used in production. Additionally, this is not as accurate as the 
// profile and should only be used for quick esitmations


public class FPS extends MonoBehaviour
{
	public Text fpsText;

	private float deltaTime;

	private void Update()
	{
		deltaTime += (Time.unscaledDeltaTime - deltaTime) * 0.1f;
		SetFPS();
	}

	private void SetFPS()
	{
		float msec = deltaTime * 1000.0f;
		float fps = 1.0f / deltaTime;
//C# TO JAVA CONVERTER TODO TASK: The '0:00.' format specifier is not converted to Java:
//C# TO JAVA CONVERTER TODO TASK: The '1:00.0' format specifier is not converted to Java:
		fpsText.text = String.format("FPS: {0:00.} ({1:00.0} ms)", fps, msec);
	}
}