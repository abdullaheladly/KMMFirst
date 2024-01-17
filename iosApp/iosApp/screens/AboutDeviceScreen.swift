//
//  AboutDeviceScreen.swift
//  iosApp
//
//  Created by abdullah on 16/01/2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI

struct AboutDeviceScreen: View {
    var body: some View {
        NavigationStack{
            AboutDeviceListView()
                .navigationTitle("About Device")
        }
    }
}

#Preview {
    AboutDeviceScreen()
}
