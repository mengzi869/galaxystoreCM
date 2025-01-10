package com.clean888.cleansuper.cleaner.utils.AboutMe;

public interface ServerTimeListener {
    void onServerTimeReceived(long serverTime);

    void onProcessComplete();
}
