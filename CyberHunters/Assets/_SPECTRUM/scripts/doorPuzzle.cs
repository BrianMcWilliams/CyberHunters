using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class doorPuzzle : MonoBehaviour {

    public GameObject doorGear;

    public void Use() 
    {
        foreach (Transform child in transform)
        {
            GameObject.Destroy(child.gameObject);
        }

        if(doorGear != null)
        {
            doorGear.SetActive(true);
        }
    }
      
        

    

}