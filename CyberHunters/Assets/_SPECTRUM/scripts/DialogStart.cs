using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class DialogStart : MonoBehaviour
{
    // Start is called before th
    public GameObject dialog;

    void OnCollisionEnter2D(Collision2D other)
    {
        dialog.SetActive (true);
    }
}
