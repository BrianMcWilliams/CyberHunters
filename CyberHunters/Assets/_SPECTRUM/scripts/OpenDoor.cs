using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class OpenDoor : MonoBehaviour
{
    public GameObject door;

    void OnCollisionEnter2D(Collision2D other)
    {
        door.SetActive (true);
    }

}
