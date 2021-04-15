import unityengine.*;

public class AutoSpikes extends MonoBehaviour
{
	public float activeDuration = 2f;

	private Animator anim;
	private AudioSource audioSource;
	private int activeParamID = Animator.StringToHash("Active");
	private float deactivationTime;
	private boolean playerInRange;
	private boolean trapActive;
	private int playerLayer;

	private void Start()
	{
		playerLayer = LayerMask.NameToLayer("Player");

		anim = GetComponent<Animator>();
		audioSource = GetComponent<AudioSource>();
	}

	private void Update()
	{
		if (trapActive && !playerInRange && Time.time >= deactivationTime)
		{
			trapActive = false;
			anim.SetBool(activeParamID, false);
		}
	}

	private void OnTriggerEnter2D(Collider2D collision)
	{
		if (collision.gameObject.layer == playerLayer)
		{
			playerInRange = true;
			trapActive = true;
			anim.SetBool(activeParamID, true);
			audioSource.Play();
		}
	}

	private void OnTriggerExit2D(Collider2D collision)
	{
		if (collision.gameObject.layer == playerLayer)
		{
			playerInRange = false;
			deactivationTime = Time.time + activeDuration;
		}
	}
}