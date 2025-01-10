package androidx.room.mul;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.clean888.cleansuper.cleaner.utils.ap2;
import com.clean888.cleansuper.cleaner.utils.bp2;
import com.clean888.cleansuper.cleaner.utils.dp2;
import com.clean888.cleansuper.cleaner.utils.ep2;
import com.clean888.cleansuper.cleaner.utils.gp2;
import com.clean888.cleansuper.cleaner.utils.hp2;
import com.clean888.cleansuper.cleaner.utils.jp2;
import com.clean888.cleansuper.cleaner.utils.kp2;
import com.clean888.cleansuper.cleaner.utils.mp2;
import com.clean888.cleansuper.cleaner.utils.np2;
import com.clean888.cleansuper.cleaner.utils.xo2;
import com.clean888.cleansuper.cleaner.utils.yo2;
import com.unity3d.player.StringFog;

@Database(entities = {xo2.class, ap2.class, dp2.class, gp2.class, jp2.class, mp2.class}, exportSchema = false, version = 1)
/* loaded from: classes2.dex */
public abstract class CommonJRoom extends RoomDatabase {
    private static volatile CommonJRoom INSTANCE;

    public static CommonJRoom getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (CommonJRoom.class) {
                if (INSTANCE == null) {
                    INSTANCE = (CommonJRoom) Room.databaseBuilder(context.getApplicationContext(), CommonJRoom.class, StringFog.decrypt("Nj0jEAoeVQs4OzIpBRAWVhY4NDwq")).build();
                }
            }
        }
        return INSTANCE;
    }

    public abstract yo2 TbaD();

    public abstract bp2 TbbD();

    public abstract ep2 TbcD();

    public abstract hp2 TbdD();

    public abstract kp2 TbeD();

    public abstract np2 TbfD();
}