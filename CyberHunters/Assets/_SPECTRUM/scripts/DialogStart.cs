using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class DialogStart : MonoBehaviour
{
    public GameObject dialog;

    void OnCollisionEnter2D(Collision2D other)
    {
        dialog.SetActive (true);
        gameObject.SetActive(false);
    }
}
