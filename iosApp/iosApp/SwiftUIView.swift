import SwiftUI
import shared
import CoreImage.CIFilterBuiltins

struct SwiftUIView: View {
    let context = CIContext()
    let filter = CIFilter.qrCodeGenerator()
    
    var body: some View {
//        Circle()
         Image(uiImage: generateQRCode(url: "adsdasq"))
             .interpolation(.none)
             .resizable()
             .scaledToFit()
             .frame(width: 200, height: 200)
    }

    func generateQRCode(url:String) -> UIImage {
        let data = Data(url.utf8)
        filter.setValue(data, forKey: "inputMessage")

        if let outputImage = filter.outputImage {
            if let cgimg = context.createCGImage(outputImage, from: outputImage.extent) {
                let image = UIImage(cgImage: cgimg)
                let saveImage = FileSystemManager().writeFile(fileName: "test.png", content: image.pngData() as Any)
                guard let readImage = FileSystemManager().readFile(fileName: "test.png") else { return UIImage()}
                return UIImage(data: readImage as! Data) ?? UIImage()
            }
        }
        return UIImage(systemName: "xmark.circle") ?? UIImage()
    }
    
}

struct SwiftUIView_Previews: PreviewProvider {
    static var previews: some View {
        SwiftUIView()
    }
}
