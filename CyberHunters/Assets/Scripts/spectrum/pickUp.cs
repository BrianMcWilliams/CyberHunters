using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class pickUp : MonoBehaviour
{
    public GameObject button;
    public GameObject wire;
    public GameObject dialog;
    public GameObject jumpButton;

    void OnCollisionEnter2D (Collision2D other)
    {
        button.SetActive (true); 
        
        if(dialog != null)
        {
            dialog.SetActive(true);
        }
        
        jumpButton.SetActive (false);
    }

    void OnCollisionExit2D (Collision2D other) 
    {
        button.SetActive (false); 
        jumpButton.SetActive (true);
    }

    public void clickThisButton()
    {
       wire.SetActive (false);
       button.SetActive (false);
       jumpButton.SetActive (true);
    }
    
}
