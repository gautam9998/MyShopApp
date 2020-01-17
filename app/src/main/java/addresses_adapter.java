import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gautam.myshop.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class addresses_adapter extends RecyclerView.Adapter<addresses_adapter.Viewholder>{
    private List<com.gautam.myshop.addresses_model>  addresses_modelList;
    public addresses_adapter(@NonNull List<com.gautam.myshop.addresses_model> addresses_modelList) {
        this.addresses_modelList = addresses_modelList;
    }

    @NonNull
    @Override

    public addresses_adapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.addresses_item_layout2,parent,false);
         return new Viewholder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull addresses_adapter.Viewholder holder, int position) {


    }

    @Override
    public int getItemCount() {
        return 0;
    }
    public class Viewholder extends RecyclerView.ViewHolder{
        private TextView fullname;
        private TextView pincode;
        private TextView addresses;



        public Viewholder(@NonNull View itemView) {
            super(itemView);
            fullname = itemView.findViewById(R.id.name);
            addresses = itemView.findViewById(R.id.address);
            pincode = itemView.findViewById(R.id.pincode);
        }
        private void setdata(String username,String useraddress,String userpincode)
        {
            fullname.setText(username);
            addresses.setText(useraddress);
            pincode.setText(userpincode);
        }
    }
}
