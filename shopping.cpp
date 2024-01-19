#include <iostream>
using namespace std;

int main() {
    int arr[5];
    string arr1[5];
    int a, b, c;

    cout << "Quantity of Product A: ";
    cin >> a;

    cout << "Quantity of Product B: ";
    cin >> b;

    cout << "Quantity of Product C: ";
    cin >> c;

    int amountA = a * 20;
    int amountB = b * 40;
    int amountC = c * 50;
    int totalAmount = amountA + amountB + amountC;

    int quantity = a + b + c;

    int shippingFee = (quantity % 10 != 0) ? ((quantity / 10) + 1) * 5 : (quantity / 10) * 5;

    cout << "Product A " << a << " Amount " << amountA << endl;
    cout << "Product B " << b << " Amount " << amountB << endl;
    cout << "Product C " << c << " Amount " << amountC << endl;
    cout << "Sub Total " << totalAmount << endl;


    cout << "Shipping fee is: " << shippingFee << endl;

    cout << "Do you want gift wrap? ";
    string inputString;
    cin >> inputString;

    int giftwrapfee = quantity;
    if (inputString == "yes") {
        cout << "Gift wrap fee is: " << quantity << endl;
    }

        if(totalAmount>200){
            arr[0]=10;
            arr1[0]="flat_10_discount";

            // resultMap.put("flat_10_discount", 10);
        }
        // if bulk_5_discount Applicable
        if(a>10||b>10||c>10){
            if(a>10){
             arr[1]=(amountA*5)/100;
            arr1[1]="bulk_5_discount";

                // int d2 = (amountA*5)/100;
                // resultMap.put("bulk_5_discount",d2);
            } else if (b>10) {
            arr[2]=(amountB*5)/100;
            arr1[2]="bulk_5_discount";

                // int d2 = (amountB*5)/100;
                // resultMap.put("bulk_5_discount",d2);
            }else {
            arr[2]=(amountC*5)/100;
            arr1[2]="bulk_5_discount";

                // int d2 = (amountC*5)/100;
                // resultMap.put("bulk_5_discount",d2);
            }
        }

        // if bulk_10_discount Applicable
        if(quantity>20){
            arr[3]=(totalAmount*10)/100;
            arr1[3]="bulk_10_discount";

            // int d3 = (totalAmount*10)/100;
            // resultMap.put("bulk_10_discount",d3);
        }

        // if tiered_50_discount is Applicable
        if(quantity>30 && (a>15||b>15||c>15)){
            int d4;
            if(a>b && a>c){
            arr[4]=(a-15)*10;
            arr1[4]="tiered_50_discount";

                // d4 =(a-15)*10;
                // resultMap.put("tiered_50_discount",d4);
            } else if (b>c) {
            arr[4]=(b-15)*20;
            arr1[4]="tiered_50_discount";

                // d4 =(b-15)*20;
                // resultMap.put("tiered_50_discount",d4);
            }
            else{
            arr[4]=(c-15)*25;
            arr1[4]="tiered_50_discount";
                // d4 =(c-15)*25;
                // resultMap.put("tiered_50_discount",d4);
            }
        }
        int maxdiscount = arr[0];
        int index=0;
        for(int i=0;i<5;i++){
            if(arr[i]>maxdiscount){
                index =i;
            }
        }

        cout<<"discount Applied "<<arr1[index]<<":"<<arr[index]<<endl;
        int totAmount = totalAmount-arr[index]+ giftwrapfee + shippingFee;
        cout<< "total Amount to pay :"<<totAmount<<endl;


}
