using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class pickUp : MonoBehaviour {

    private Inventory inventory;
    public GameObject itemButton;
    public GameObject button;
    public GameObject wire;
    public GameObject dialog;
    public GameObject jumpButton;


    private void Start()
    {
        inventory = GameObject.FindGameObjectWithTag("Player").GetComponent<Inventory>();
    }

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

       for (int i = 0; i < inventory.slots.Length; i++)      
       {  
            if (inventory.isFull[i] == false) 
            { 
                inventory.isFull[i] = true; 
                Instantiate(itemButton, inventory.slots[i].transform, false); 
                break;
                
            }
        }


    }
    
}