import unityengine.*;

public class FallingBlockCollision extends MonoBehaviour
{
	private Rigidbody2D rigidBody;
	private BoxCollider2D box;
	private AudioSource audioSource;
	private LayerMask groundMask;
	private int groundLayer;


	private void Start()
	{
		rigidBody = GetComponent<Rigidbody2D>();
		box = GetComponent<BoxCollider2D>();
		audioSource = GetComponent<AudioSource>();

		groundMask = LayerMask.GetMask("Platforms");
		groundLayer = LayerMask.NameToLayer("Platforms");
	}

	public final void Fall()
	{
		rigidBody.bodyType = RigidbodyType2D.Dynamic;
	}

	private void OnTriggerEnter2D(Collider2D collision)
	{
		if (collision.gameObject.layer != groundLayer)
		{
			return;
		}

		Vector3 pos = rigidBody.position;
		RaycastHit2D hit;

		hit = Physics2D.Raycast(pos, Vector2.down, 1f, groundMask);
		pos.y = hit.point.y + .5f;
		transform.position = pos;

		box.usedByComposite = true;
		Destroy(rigidBody);

		audioSource.Play();
	}
}