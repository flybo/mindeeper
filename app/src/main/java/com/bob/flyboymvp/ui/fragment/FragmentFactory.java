package com.bob.flyboymvp.ui.fragment;

import com.bob.flyboymvp.ui.fragment.contacts.PersonalFragment;

/**
 * @描述 主界面4个Fragment工厂
 */
public class FragmentFactory {

    static FragmentFactory mInstance;

    private FragmentFactory() {}

    public static FragmentFactory getInstance() {
        if (mInstance == null) {
            synchronized (FragmentFactory.class) {
                if (mInstance == null) {
                    mInstance = new FragmentFactory();
                }
            }
        }
        return mInstance;
    }

    private CloudFragment mCloudFragment;
    public CloudFragment getCloudFragment() {
        if (mCloudFragment == null) {
            synchronized (FragmentFactory.class) {
                if (mCloudFragment == null) {
                    mCloudFragment = new CloudFragment();
                }
            }
        }
        return mCloudFragment;
    }
    private ChatFragment mChatFragment;
    public ChatFragment getChatFragment() {
        if (mChatFragment == null) {
            synchronized (ChatFragment.class) {
                if (mChatFragment == null) {
                    mChatFragment = new ChatFragment();
                }
            }
        }
        return mChatFragment;
    }
    private ContactsFragment mContactsFragment;
    public ContactsFragment getContactsFragment() {
        if (mContactsFragment == null) {
            synchronized (ContactsFragment.class) {
                if (mContactsFragment == null) {
                    mContactsFragment = new ContactsFragment();
                }
            }
        }
        return mContactsFragment;
    }
    private SendFragment mSendFragment;
    public SendFragment getSendFragment() {
        if (mSendFragment == null) {
            synchronized (SendFragment.class) {
                if (mSendFragment == null) {
                    mSendFragment = new SendFragment();
                }
            }
        }
        return mSendFragment;
    }

    private PersonalFragment mPersonalFragment;
    public PersonalFragment getPersonalFragment() {
        if (mPersonalFragment == null) {
            synchronized (PersonalFragment.class) {
                if (mPersonalFragment == null) {
                    mPersonalFragment = new PersonalFragment();
                }
            }
        }
        return mPersonalFragment;
    }


}
