/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        return addTwoNumbersCarry(l1,l2,0);
    }
    ListNode* addTwoNumbersCarry(ListNode* l1, ListNode* l2, int carry){
        if(l1 == NULL && l2 == NULL && carry == 0) return NULL;
        int newVal = ((l1==NULL)?0:l1->val) + ((l2==NULL)?0:l2->val) + carry;
        ListNode *newNode = new ListNode(newVal%10);
        newVal/=10;
        if(l1==NULL&&l2==NULL) newNode->next=addTwoNumbersCarry(NULL, NULL, newVal);
        else if(l2==NULL) newNode->next=addTwoNumbersCarry(l1->next, NULL, newVal);
        else if(l1==NULL) newNode->next=addTwoNumbersCarry(NULL, l2->next, newVal);
        else newNode->next=addTwoNumbersCarry(l1->next, l2->next, newVal);
        return newNode;
    }
};

