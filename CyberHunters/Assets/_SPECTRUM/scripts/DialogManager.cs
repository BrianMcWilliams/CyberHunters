using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class DialogManager : MonoBehaviour
{
    public static bool isTalking = false;
    public static int indexEnd;

    // Start is called before the first frame update
    void Start()
    {
        
    }

    // Update is called once per frame
    void Update()
    {

        
    }

    public static void StartTalking()
    {
        isTalking = true;
    }

    public static void StopTalking()
    {
        isTalking = false;
    }

}
