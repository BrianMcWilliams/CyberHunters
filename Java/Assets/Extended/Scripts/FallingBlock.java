import unityengine.*;

public class FallingBlock extends MonoBehaviour
{
	public FallingBlockCollision block;

	private Animator anim;
	private BoxCollider2D box;
	private AudioSource audioSource;
	private int playerLayer;
	private int fallParamID;


	private void Start()
	{
		anim = GetComponent<Animator>();
		box = GetComponent<BoxCollider2D>();
		audioSource = GetComponent<AudioSource>();

		playerLayer = LayerMask.NameToLayer("Player");
		fallParamID = Animator.StringToHash("Activate");
	}

	public final void Fall()
	{
		block.Fall();
	}

	private void OnTriggerEnter2D(Collider2D collision)
	{
		if (collision.gameObject.layer != playerLayer)
		{
			return;
		}

		box.enabled = false;
		audioSource.Play();
		anim.SetTrigger(fallParamID);
	}
}