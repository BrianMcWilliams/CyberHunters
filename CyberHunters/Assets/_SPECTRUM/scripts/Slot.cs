using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Slot : MonoBehaviour {

    public GameObject doorGear;
    public GameObject On;
    public GameObject button;
    private Inventory inventory;

    private void Start()
    {
        inventory = GameObject.FindGameObjectWithTag("door").GetComponent<Inventory>();
    }

    public void Use() {

        foreach (Transform child in transform)
        {
            GameObject.Destroy(child.gameObject);
        }

    

        if(doorGear != null)
        {
            for (int i = 0; i < inventory.slots.Length; i++)      
            {  
            
                if (inventory.isFull[i] == false) 
                { 
                    inventory.isFull[i] = true; 
                    Instantiate(doorGear, inventory.slots[i].transform, false); 
                    break;  
                }

                if(inventory.isFull[i] == true)
                {    
                    if(On && button != null)
                    {
                       On.SetActive(true);
                       button.SetActive(true);
                    }
                
                }
        
            }
        }
      
        

    }

}

