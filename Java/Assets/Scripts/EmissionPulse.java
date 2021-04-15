import unityengine.*;

// This script makes the emissive property of a material "pulse". It is used to make
// background detail tilemap glow. This is purely cosmetic and can be removed for efficiency 
// on mobile platforms


public class EmissionPulse extends MonoBehaviour
{
	public float maxIntensity = 15f; //The max emissive intensity
	public float damping = 2f; //The damping to control the pulse speed

	private Material material; //The material being controlled
	private int emissionColorProperty; //The ID of the emission property


	private void Start()
	{
		//Get a reference to the Renderer component so we can store the material of it
		Renderer renderer = GetComponent<Renderer>();
		material = renderer.material;

		//Convert the property ID string to an integer. This is much more efficient
		//than using strings to control material properties
		emissionColorProperty = Shader.PropertyToID("_EmissionColor");
	}

	private void Update()
	{
		//Calculate the emission value based on Time and intensity
		float emission = Mathf.PingPong(Time.time * damping, maxIntensity);

		//Convert this to a color value
		Color finalColor = Color.white * emission;

		//Apply the color to the material
		material.SetColor(emissionColorProperty, finalColor);
	}
}