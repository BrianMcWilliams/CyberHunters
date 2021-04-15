//====================================================================================================
//The Free Edition of C# to Java Converter limits conversion output to 100 lines per file.

//To purchase the Premium Edition, visit our website:
//https://www.tangiblesoftwaresolutions.com/order/order-csharp-to-java.html
//====================================================================================================

import java.util.*;

// This script is a Manager that controls all of the audio for the project. All audio
// commands are issued through the static methods of this class. Additionally, this 
// class creates AudioSource "channels" at runtime and manages them

import unityengine.*;
import unityengine.Audio.*;

public class AudioManager extends MonoBehaviour
{
	//This class holds a static reference to itself to ensure that there will only be
	//one in existence. This is often referred to as a "singleton" design pattern. Other
	//scripts access this one through its public static methods
	private static AudioManager current;

//C# TO JAVA CONVERTER TODO TASK: Java annotations will not correspond to .NET attributes:
//ORIGINAL LINE: [Header("Ambient Audio")] public AudioClip ambientClip;
	public AudioClip ambientClip; //The background ambient sound
	public AudioClip musicClip; //The background music

//C# TO JAVA CONVERTER TODO TASK: Java annotations will not correspond to .NET attributes:
//ORIGINAL LINE: [Header("Stings")] public AudioClip levelStingClip;
	public AudioClip levelStingClip; //The sting played when the scene loads
	public AudioClip deathStingClip; //The sting played when the player dies
	public AudioClip winStingClip; //The sting played when the player wins
	public AudioClip orbStingClip; //The sting played when an orb is collected
	public AudioClip doorOpenStingClip; //The sting played when the door opens

//C# TO JAVA CONVERTER TODO TASK: Java annotations will not correspond to .NET attributes:
//ORIGINAL LINE: [Header("Robbie Audio")] public AudioClip[] walkStepClips;
	public AudioClip[] walkStepClips; //The footstep sound effects
	public AudioClip[] crouchStepClips; //The crouching footstep sound effects
	public AudioClip deathClip; //The player death sound effect
	public AudioClip jumpClip; //The player jump sound effect

	public AudioClip jumpVoiceClip; //The player jump voice
	public AudioClip deathVoiceClip; //The player death voice
	public AudioClip orbVoiceClip; //The player orb collection voice
	public AudioClip winVoiceClip; //The player wins voice

//C# TO JAVA CONVERTER TODO TASK: Java annotations will not correspond to .NET attributes:
//ORIGINAL LINE: [Header("Mixer Groups")] public AudioMixerGroup ambientGroup;
	public AudioMixerGroup ambientGroup; //The ambient mixer group
	public AudioMixerGroup musicGroup; //The music mixer group
	public AudioMixerGroup stingGroup; //The sting mixer group
	public AudioMixerGroup playerGroup; //The player mixer group
	public AudioMixerGroup voiceGroup; //The voice mixer group

	private AudioSource ambientSource; //Reference to the generated ambient Audio Source
	private AudioSource musicSource; //Reference to the generated music Audio Source
	private AudioSource stingSource; //Reference to the generated sting Audio Source
	private AudioSource playerSource; //Reference to the generated player Audio Source
	private AudioSource voiceSource; //Reference to the generated voice Audio Source


	private void Awake()
	{
		//If an AudioManager exists and it is not this...
		if (current != null && current != this)
		{
			//...destroy this. There can be only one AudioManager
			Destroy(gameObject);
			return;
		}

		//This is the current AudioManager and it should persist between scene loads
		current = this;
		DontDestroyOnLoad(gameObject);

		//Generate the Audio Source "channels" for our game's audio
		Object tempVar = gameObject.<AudioSource>AddComponent();
		ambientSource = tempVar instanceof AudioSource ? (AudioSource)tempVar : null;
		Object tempVar2 = gameObject.<AudioSource>AddComponent();
		musicSource = tempVar2 instanceof AudioSource ? (AudioSource)tempVar2 : null;
		Object tempVar3 = gameObject.<AudioSource>AddComponent();
		stingSource = tempVar3 instanceof AudioSource ? (AudioSource)tempVar3 : null;
		Object tempVar4 = gameObject.<AudioSource>AddComponent();
		playerSource = tempVar4 instanceof AudioSource ? (AudioSource)tempVar4 : null;
		Object tempVar5 = gameObject.<AudioSource>AddComponent();
		voiceSource = tempVar5 instanceof AudioSource ? (AudioSource)tempVar5 : null;

		//Assign each audio source to its respective mixer group so that it is
		//routed and controlled by the audio mixer
		ambientSource.outputAudioMixerGroup = ambientGroup;
		musicSource.outputAudioMixerGroup = musicGroup;
		stingSource.outputAudioMixerGroup = stingGroup;
		playerSource.outputAudioMixerGroup = playerGroup;
		voiceSource.outputAudioMixerGroup = voiceGroup;

		//Being playing the game audio
		StartLevelAudio();
	}

	private void StartLevelAudio()
	{
		//Set the clip for ambient audio, tell it to loop, and then tell it to play
		current.ambientSource.clip = current.ambientClip;
		current.ambientSource.loop = true;
		current.ambientSource.Play();

		//Set the clip for music audio, tell it to loop, and then tell it to play
		current.musicSource.clip = current.musicClip;
		current.musicSource.loop = true;
		current.musicSource.Play();

		//Play the audio that repeats whenever the level reloads
		PlaySceneRestartAudio();
	}

	public static void PlayFootstepAudio()
	{
		//If there is no current AudioManager or the player source is already playing
		//a clip, exit 
		if (current == null || current.playerSource.isPlaying)
		{
			return;
		}

		//Pick a random footstep sound
		int index = Random.Range(0, current.walkStepClips.length);

		//Set the footstep clip and tell the source to play
		current.playerSource.clip = current.walkStepClips[index];
		current.playerSource.Play();
	}

	public static void PlayCrouchFootstepAudio()
	{
		//If there is no current AudioManager or the player source is already playing
		//a clip, exit 
		if (current == null || current.playerSource.isPlaying)
		{
			return;
		}

		//Pick a random crouching footstep sound
		int index = Random.Range(0, current.crouchStepClips.length);

		//Set the footstep clip and tell the source to play
		current.playerSource.clip = current.crouchStepClips[index];
		current.playerSource.Play();
	}

	public static void PlayJumpAudio()
	{
		//If there is no current AudioManager, exit
		if (current == null)
		{
			return;
		}

		//Set the jump SFX clip and tell the source to play
		current.playerSource.clip = current.jumpClip;
		current.playerSource.Play();

		//Set the jump voice clip and tell the source to play
		current.voiceSource.clip = current.jumpVoiceClip;
		current.voiceSource.Play();
	}

	public static void PlayDeathAudio()
	{
		//If there is no current AudioManager, exit
		if (current == null)
		{
			return;
		}

		//Set the death SFX clip and tell the source to play
		current.playerSource.clip = current.deathClip;
		current.playerSource.Play();

		//Set the death voice clip and tell the source to play
		current.voiceSource.clip = current.deathVoiceClip;
		current.voiceSource.Play();

		//Set the death sting clip and tell the source to play
		current.stingSource.clip = current.deathStingClip;
		current.stingSource.Play();
	}


	public static void PlayOrbCollectionAudio()
	{
		//If there is no current AudioManager, exit
		if (current == null)
		{
			return;
		}

		//Set the orb sting clip and tell the source to play
		current.stingSource.clip = current.orbStingClip;
		current.stingSource.Play();

		//Set the orb voice clip and tell the source to play
		current.voiceSource.clip = current.orbVoiceClip;
		current.voiceSource.Play();
	}

	public static void PlaySceneRestartAudio()
	{
		//If there is no current AudioManager, exit
		if (current == null)
		{
			return;
		}

		//Set the level reload sting clip and tell the source to play
		current.stingSource.clip = current.levelStingClip;
		current.stingSource.Play();
	}


//====================================================================================================
//End of the allowed output for the Free Edition of C# to Java Converter.

//To purchase the Premium Edition, visit our website:
//https://www.tangiblesoftwaresolutions.com/order/order-csharp-to-java.html
//====================================================================================================
