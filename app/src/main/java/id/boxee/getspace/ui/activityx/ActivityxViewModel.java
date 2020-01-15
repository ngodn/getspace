package id.boxee.getspace.ui.activityx;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ActivityxViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ActivityxViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is activity fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}