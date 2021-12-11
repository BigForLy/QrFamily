import SwiftUI
import shared


struct ContentView: View {
	let greet = Greeting().greeting()
	let b = Greeting().temporaryDirectory()

	var body: some View {
        NavigationView {
            VStack {
                Text(b)
                Text(greet)
                Text(greet)
                NavigationLink(destination: SwiftUIView()) {
                    Text("Do Something")
                }
            }
        }
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}
