using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class RobotActivate : MonoBehaviour
{
    public GameObject robot; 
    public GameObject dialog;

    void OnCollisionEnter2D (Collision2D other)
    {
        GameObject Robot = other.gameObject;
        if (Robot.CompareTag("Robot"))
        {
            Robot.SetActive(false);
            robot.SetActive(true); 
            dialog.SetActive(true);
        }
        else
        {
            return;

        }
    }
    
}
