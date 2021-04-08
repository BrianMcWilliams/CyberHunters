using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class OpenInventory : MonoBehaviour
{
    public GameObject openButton;
    public GameObject exitButton;
    public GameObject inventory;

    public void clickThisButton()
    {
        exitButton.SetActive(true);
        inventory.SetActive (true);
        openButton.SetActive (false);
    } 

    public void clickedThisButton()
    {
        exitButton.SetActive(false);
        inventory.SetActive(false);
        openButton.SetActive(true);
    }



}
