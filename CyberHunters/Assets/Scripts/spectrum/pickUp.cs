using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class pickUp : MonoBehaviour
{
    public GameObject button;
    public GameObject wire;
    public GameObject dialog;

    void OnCollisionEnter2D (Collision2D other)
    {
        button.SetActive (true); 
        dialog.SetActive(true);
    }

    public void clickThisButton()
    {
       wire.SetActive (false);
       button.SetActive (false);
    }
    
}
