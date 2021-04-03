using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class ElectricWire : MonoBehaviour
{
    public GameObject buttonPickUp;
    void Start()
    {
        buttonPickUp.SetActive(false);
    }
    void OnCollisionEnter(Collision collision)
    {
        GameObject collisionObject = collision.gameObject;
        PlayerMovement mouvementComponant = gameObject.GetComponent<PlayerMovement>();
        if (mouvementComponant == null)
        {
            return;
        }
        else
        {
            buttonPickUp.SetActive(true);
        }
    }
    private void OnCollisionExit(Collision collision)
    {
        GameObject collisionObject = collision.gameObject;
        PlayerMovement mouvementComponant = gameObject.GetComponent<PlayerMovement>();
        if (mouvementComponant == null)
        {
            return;
        }
        else
        {
            buttonPickUp.SetActive(false);
        }
    }
}
