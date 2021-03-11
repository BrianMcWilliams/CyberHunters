using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;

public class TeleportationLevel : MonoBehaviour
{
    public int indexLevel;

    void OnTriggerEnter2D (Collider2D other)
    {
        if (other.CompareTag("Player"))
        {
            SceneManager.LoadScene(indexLevel);
        }
        
    }
}
