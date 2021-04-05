using System.Collections;
using System.Collections.Generic;
using UnityEngine;


public class On : MonoBehaviour
{
    public GameObject Activate;
    public GameObject button;


    void Update()
    {
        foreach (Transform child in transform)     
        {  
            if (!child.gameObject.activeInHierarchy) 
            { 
                return;
                
                
            }
            else
            {
                Activate.SetActive(true);
                button.SetActive(true);
            }
        }     
         
    }
    
}
