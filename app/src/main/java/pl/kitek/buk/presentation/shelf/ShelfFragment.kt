package pl.kitek.buk.presentation.shelf

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.shelf_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import pl.kitek.buk.R
import pl.kitek.buk.presentation.shelf.adapter.ShelfAdapter

class ShelfFragment : Fragment() {

    private val viewModel: ShelfViewModel by viewModel()
    private val adapter = ShelfAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.shelf_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        shelfRv.layoutManager = LinearLayoutManager(requireContext())
        shelfRv.adapter = adapter

        viewModel.getBooks().observe(this, Observer { books ->
            adapter.items = books
        })
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.shelf_menu, menu)
    }

}
