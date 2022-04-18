import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.marginBottom
import com.example.todoapp.R
import com.example.todoapp.ui.main.data.SettingItem
import com.xwray.groupie.Item
import com.xwray.groupie.GroupieViewHolder

class SettingGroupieItem(
    private val item:SettingItem,
    private val onClickListener: View.OnClickListener? = null
    ) : Item<GroupieViewHolder>() {

    override fun getLayout(): Int {
        return R.layout.setting_list_item
    }

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        val menuName = viewHolder.itemView.findViewById<TextView>(R.id.setting_menu_name)
        val menuIcon = viewHolder.itemView.findViewById<ImageView>(R.id.setting_menu_icon)
        val menuItemValue = viewHolder.itemView.findViewById<TextView>(R.id.setting_menu_value)
        val menuNextBtn = viewHolder.itemView.findViewById<ImageView>(R.id.setting_menu_next)
        val menuItem = viewHolder.itemView.findViewById<ConstraintLayout>(R.id.setting_menu_column)

        menuName.apply {
            text = item.name
            contentDescription = item.description
        }

        menuIcon.apply {
            visibility = View.INVISIBLE
            item.image?.let {
                visibility = View.VISIBLE
                this.setImageResource(it)
            }
        }

        menuItemValue.apply {
            visibility = View.INVISIBLE
            item.value?.let {
                menuNextBtn.visibility = View.INVISIBLE
                this.visibility = View.VISIBLE
                text = item.value
            }
        }

        menuItem.apply{
            setOnClickListener(onClickListener)
            when(item.name) {
                "버전" -> {
                    setPadding(0,60,0,0)
                }
            }

        }
    }
}