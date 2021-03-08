using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class pickUp : MonoBehaviour
{
    public GameObject button;
    public GameObject wire;

    void OnCollisionEnter2D (Collision2D other)
    {
        button.SetActive (true); 
    }

    public void clickThisButton()
    {
       wire.SetActive (false);
       button.SetActive (false);
    }
    
}
