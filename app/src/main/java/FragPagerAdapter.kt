import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.spacemachine.Fragments.EnergyCoreFragment
import com.example.spacemachine.Fragments.EngineFragment
import com.example.spacemachine.Fragments.StatusDispFragment
import com.example.spacemachine.Fragments.VitalHabitatFragment

class FragPagerAdapter (activity : FragmentActivity) : FragmentStateAdapter (activity) {

    override fun createFragment(position: Int): Fragment {

        return when (position) {
            0 -> StatusDispFragment()
            1 -> EngineFragment ()
            2 -> VitalHabitatFragment ()
            3 -> EnergyCoreFragment()
                else -> {
                    StatusDispFragment()
                }
        }
    }
    override fun getItemCount(): Int = 4
}