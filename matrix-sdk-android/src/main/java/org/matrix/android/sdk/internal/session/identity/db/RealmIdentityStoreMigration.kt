/*
 * Copyright 2020 The Matrix.org Foundation C.I.C.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.matrix.android.sdk.internal.session.identity.db

import io.realm.DynamicRealm
import io.realm.RealmMigration
import org.matrix.android.sdk.internal.session.identity.db.migration.MigrateIdentityTo001
import timber.log.Timber
import javax.inject.Inject

internal class RealmIdentityStoreMigration @Inject constructor() : RealmMigration {
    /**
     * Forces all RealmIdentityStoreMigration instances to be equal
     * Avoids Realm throwing when multiple instances of the migration are set
     */
    override fun equals(other: Any?) = other is RealmIdentityStoreMigration
    override fun hashCode() = 3000

    val schemaVersion = 1L

    override fun migrate(realm: DynamicRealm, oldVersion: Long, newVersion: Long) {
        Timber.d("Migrating Realm Identity from $oldVersion to $newVersion")

        if (oldVersion < 1) MigrateIdentityTo001(realm).perform()
    }
}
