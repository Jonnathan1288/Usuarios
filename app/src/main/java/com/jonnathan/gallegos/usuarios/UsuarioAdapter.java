package com.jonnathan.gallegos.usuarios;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jonnathan.gallegos.usuarios.Modelo.ModeloUsuario;

import java.util.List;

public class UsuarioAdapter extends RecyclerView.Adapter<UsuarioAdapter.UserAdapterVH> {

    private List<ModeloUsuario> userResponseList;
    private Context context;
    private ClickedItem clickedItem;

    public UsuarioAdapter(ClickedItem clickedItem) {
        this.clickedItem = clickedItem;
    }

    public void setData(List<ModeloUsuario> userResponseList) {
        this.userResponseList = userResponseList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public UserAdapterVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new UserAdapterVH(LayoutInflater.from(context).inflate(R.layout.row_users,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapterVH holder, int position) {

        ModeloUsuario userResponse = userResponseList.get(position);

        String username = userResponse.getAuthor();
        String prefix;
        switch (userResponse.getAuthor()){
            case "Edsger W. Dijkstra":
                prefix = "E";
                break;
            case "Tony Hoare":
                prefix = "T";
                break;
            case "Jeff Hammerbacher":
                prefix = "J";
                break;
            case "Fred Brooks":
                prefix = "F";
                break;
            case "Michael Stal":
                prefix = "M";
                break;
            default:
                prefix = "N";
            break;
        }

        holder.prefix.setText(prefix);
        holder.username.setText(username);
        holder.imageMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickedItem.ClickedUser(userResponse);
            }
        });
    }

    public interface ClickedItem{
        public void ClickedUser(ModeloUsuario userResponse);
    }

    @Override
    public int getItemCount() {
        return userResponseList.size();
    }

    public class UserAdapterVH extends RecyclerView.ViewHolder {
        TextView username;
        TextView prefix;
        ImageView imageMore;

        public UserAdapterVH(@NonNull View itemView) {
            super(itemView);
            username = itemView.findViewById(R.id.username);
            prefix = itemView.findViewById(R.id.prefix);
            imageMore = itemView.findViewById(R.id.imageMore);
        }
    }
}
